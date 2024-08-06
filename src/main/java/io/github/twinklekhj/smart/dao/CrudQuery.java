package io.github.twinklekhj.smart.dao;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CrudQuery {
    private String insert;
    private String update;
    private String delete;
    private String count;
    private String check;
    private String selectOne;
    private String selectList;
}
