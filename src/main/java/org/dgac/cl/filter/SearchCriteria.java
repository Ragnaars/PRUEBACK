package org.dgac.cl.filter;

import org.dgac.cl.enums.SearchOperation;

import lombok.Data;

@Data
public class SearchCriteria {

    private String key;

    private String key2;

    private Object value;

    private Object value2;

    private SearchOperation operation;

    public SearchCriteria(String key, Object value, SearchOperation operation){
        this.key = key; 
        this.value = value;
        this.operation = operation;
    }

    public SearchCriteria(String key, SearchOperation operation){
        super();
        this.key = key; 
        this.operation = operation;
    }

    public SearchCriteria(String key, Object value, String key2, Object value2, SearchOperation operation){
        super();
        this.key = key; 
        this.value = value;
        this.key2 = key2;
        this.value2 = value2;
        this.operation = operation;
    }


    public SearchCriteria(String key, Object value, Object value2, SearchOperation operation){
        this.key = key; 
        this.value = value;
        this.value2 = value2;
        this.operation = operation;
    }




}
