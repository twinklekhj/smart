package io.github.twinklekhj.smart.dao;

import io.github.twinklekhj.smart.api.type.PageVO;
import io.github.twinklekhj.smart.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public abstract class CrudService<E, PK> {
    private final SqlSessionTemplate template;

    @Setter
    private CrudQuery query;

    protected CrudService(SqlSessionTemplate template) {
        this.template = template;
    }

    /**
     * [CrudTemplate] insert 문 실행
     *
     * @param entity
     * @return
     */
    public final int executeInsert(E entity) {
        Assert.notNull(query.getInsert(), "Mapper 등록해주세요! - insert");
        return template.insert(query.getInsert(), entity);
    }

    public final int executeUpdate(Object param) {
        Assert.notNull(query.getUpdate(), "Mapper 등록해주세요! - update");
        return template.update(query.getUpdate(), param);
    }

    public final int executeDelete(PK id) {
        Assert.notNull(query.getDelete(), "Mapper 등록해주세요! - delete");
        return template.delete(query.getDelete(), id);
    }

    public final int executeCountBy(Object param) {
        Assert.notNull(query.getCount(), "Mapper 등록해주세요! - count");
        return template.selectOne(query.getCount(), param);
    }

    public final List<E> executeFindAll() {
        Assert.notNull(query.getSelectList(), "Mapper 등록해주세요! - list");
        return template.selectList(query.getSelectList());
    }

    public final List<E> executeFindAllBy(Object param) {
        Assert.notNull(query.getSelectList(), "Mapper 등록해주세요! - list");
        return template.selectList(query.getSelectList(), param);
    }

    public final Optional<E> executeFindById(PK id) {
        Assert.notNull(query.getSelectOne(), "Mapper 등록해주세요! - one");
        return Optional.ofNullable(template.selectOne(query.getSelectOne(), id));
    }

    public ResponseEntity<PageVO<E>> findPageBy(Object param) {
        return ResponseEntity.ok(PageVO.builder(executeFindAllBy(param), executeCountBy(param)).build());
    }

    public ResponseEntity<PageVO<E>> findAll() {
        return ResponseEntity.ok(PageVO.<E>builder(executeFindAll()).build());
    }

    public ResponseEntity<PageVO<E>> findAllBy(Object param) {
        return ResponseEntity.ok(PageVO.<E>builder(executeFindAllBy(param)).build());
    }

    public ResponseEntity<E> findById(PK id) {
        Optional<E> entityOptional = Optional.ofNullable(template.selectOne(query.getSelectOne(), id));
        if(entityOptional.isPresent()){
            return ResponseEntity.ok(entityOptional.get());
        }
        throw new DataNotFoundException();
    }

    public ResponseEntity<?> insert(E entity) {
        int result = executeInsert(entity);
        if(result > 0){
            return ResponseEntity.ok("성공적으로 추가되었습니다");
        }
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<?> updateById(Object param) {
        int result = executeUpdate(param);
        if(result > 0){
            return ResponseEntity.ok("성공적으로 수정되었습니다.");
        }
        throw new DataNotFoundException();
    }

    public ResponseEntity<?> deleteById(PK id) {
        int result = executeDelete(id);
        if(result > 0){
            return ResponseEntity.ok("성공적으로 삭제되었습니다.");
        }
        throw new DataNotFoundException();
    }
}
