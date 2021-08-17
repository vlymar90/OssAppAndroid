package com.example.ossapp.dto;

public class StyleLevelDto {
    private long style;
    private long level;

    public StyleLevelDto(long style, long level) {
        this.style = style;
        this.level = level;
    }

    public long getStyle() {
        return style;
    }

    public long getLevel() {
        return level;
    }

    public void setStyle(long style) {
        this.style = style;
    }

    public void setLevel(long level) {
        this.level = level;
    }
}
