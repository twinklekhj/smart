package io.github.twinklekhj.smart.api.type;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class PageVO <T> {
    @Builder.Default
    private int pageIdx = 1;

    @Builder.Default
    private int pageSize = 25;

    @Builder.Default
    private int pageCount = 1;

    private T[] items;

    @Builder.Default
    private long itemsCount = 0;

    private static <T> PageVOBuilder<T> builder() {
        return new PageVOBuilder<T>();
    }

    public static <T> PageVOBuilder<T> builder(List<T> items) {
        return (PageVOBuilder<T>) builder()
                .items(items.toArray()).pageSize(items.size()).itemsCount(items.size());
    }

    public static <T> PageVOBuilder<T> builder(List<T> items, int count) {
        return (PageVOBuilder<T>) builder()
                .items(items.toArray()).pageSize(items.size())
                .pageCount((int) Math.ceil(count / items.size()))
                .itemsCount(items.size());
    }


    @SafeVarargs
    public static <T> PageVOBuilder<T> builder(T... items) {
        return (PageVOBuilder<T>) builder()
                .items(items).pageSize(items.length).itemsCount(items.length);
    }
}