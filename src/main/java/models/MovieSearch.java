package models;

import lombok.Data;

import java.util.List;

@Data
public class MovieSearch {

    List<SearchObject> search;

    String totalResults;
    String Response;
}
