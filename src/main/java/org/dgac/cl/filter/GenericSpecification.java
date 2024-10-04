package org.dgac.cl.filter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class GenericSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = 1900581010229669687L;

	private List<SearchCriteria> list;

	public GenericSpecification() {
		this.list = new ArrayList<>();
	}

	public void add(SearchCriteria criteria) {
		list.add(criteria);
	}

	@SuppressWarnings("null")
    @Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		List<Predicate> predicates = new ArrayList<>();

		for (SearchCriteria criteria : list) {
			switch (criteria.getOperation()) {
				case EQUAL -> predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
				case GREATER_THAN -> predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
				case GREATER_THAN_EQUAL -> predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
				case GREATER_THAN_EQUAL_DATE -> predicates.add(builder.greaterThanOrEqualTo(root.<LocalDate>get(criteria.getKey()), (LocalDate) criteria.getValue()));
				case GREATER_THAN_EQUAL_DATETIME -> predicates.add(builder.greaterThanOrEqualTo(root.<LocalDateTime>get(criteria.getKey()), (LocalDateTime) criteria.getValue()));
				case IN -> predicates.add(root.get(criteria.getKey()).in((Object[]) criteria.getValue()));
				case LESS_THAN -> predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
				case LESS_THAN_EQUAL -> predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
				case LESS_THAN_EQUAL_DATE -> predicates.add(builder.lessThanOrEqualTo(root.<LocalDate>get(criteria.getKey()), LocalDate.parse(criteria.getValue().toString())));
				case LESS_THAN_EQUAL_DATETIME -> predicates.add(builder.lessThanOrEqualTo(root.<LocalDateTime>get(criteria.getKey()), (LocalDateTime) criteria.getValue()));
				case MATCH -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
				case MATCH_END -> predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), criteria.getValue().toString().toLowerCase() + "%"));
				case NOT_EQUAL -> predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
				case SUB_ID -> predicates.add(builder.equal(root.join(criteria.getKey()).get("id"), criteria.getValue()));
				case SUB -> {
                                    String[] aux = criteria.getKey().split(",");
                                    if (aux != null && aux.length >= 2) {
                                        predicates.add(builder.like(builder.lower(root.join(aux[0]).get(aux[1])), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                                    }
                        }
				case SUB_IN ->  {
					String[] aux2 = criteria.getKey().split(",");
					Join<Object, Object> join = null;
					for (int i = 0; i < aux2.length; i++) {
						if (i == 0) {
							join = root.join(aux2[i]);
						} else {
							join = join.join(aux2[i]);
						}
					}
					if (join != null) {
						predicates.add(join.in((Object[]) criteria.getValue()));
					}
					query.distinct(true);
				}
				case SUB_ID_LEVEL ->  {
					String[] aux2 = criteria.getKey().split(",");
					String[] attribute = criteria.getKey().split("_");
					Join<Object, Object> join = null;
					for (int i = 0; i < aux2.length; i++) {
						if (i == 0) {
							join = root.join(aux2[i]);
						} else {
							join = join.join(aux2[i]);
						}
					}
					if (attribute.length > 0) {
						join.get(attribute[0]);
					}
					predicates.add(builder.equal(join, criteria.getValue()));
				}
				case CHAIN ->  {
					String[] aux2 = criteria.getKey().split(",");
					Join<Object, Object> join = null;
					for (int i = 0; i < aux2.length; i++) {
						if (i == 0) {
							join = root.join(aux2[i]);
						} else {
							join = join.join(aux2[i]);
						}
					}
					predicates.add(builder.equal(criteria.getKey2() != null ? join.get(criteria.getKey2()) : join, criteria.getValue()));
				}
				case CHAIN_MATCH ->  {
					String[] aux2 = criteria.getKey().split(",");
					Join<Object, Object> join = null;
					for (int i = 0; i < aux2.length; i++) {
						if (i == 0) {
							join = root.join(aux2[i]);
						} else {
							join = join.join(aux2[i]);
						}
					}
					predicates.add(builder.like(builder.lower(join.get(criteria.getKey2())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
				}
				case NULL ->  {
					predicates.add(builder.isNull(root.get(criteria.getKey())));
				}
				
				case DATE_EQUAL -> {
					Expression<String> fechaFormateada = builder.function(
						"TO_CHAR", 
						String.class, 
						root.get(criteria.getKey()), 
						builder.literal("yyyy-mm-dd")
					);

					predicates.add(builder.equal(fechaFormateada, criteria.getValue().toString()));
				}
				default -> {

                }
			}
		}

		return builder.and(predicates.toArray(Predicate[]::new));
	}
}
