package org.demo2.base;

import java.awt.*;

enum ElementError{
    ElementNotExist("元素不存在",1), ElemenNotRight("dsd",2);
    private String errorName;
    private int index;
    private ElementError(String errorName, int index){
        this.errorName = errorName;
        this.index = index;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
