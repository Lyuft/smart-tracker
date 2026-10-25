package org.smart_tracker.backend.dto.response;

import java.util.List;

public record PageData<T>(List<T> content) {
    public static <T> PageData<T> of(List<T> content) {
        return new PageData<>(content);
    }
}
