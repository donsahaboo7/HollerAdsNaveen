package com.a2zdevelopers.hollerads.Model;

public class DataItem {
    private String cTypeName;
    private String cFunctionName;

    public DataItem() {
    }

    public DataItem(String cTypeName, String cFunctionName) {
        this.cTypeName = cTypeName;
        this.cFunctionName = cFunctionName;
    }

    public String getcTypeName() {
        return cTypeName;
    }

    public void setcTypeName(String cTypeName) {
        this.cTypeName = cTypeName;
    }

    public String getcFunctionName() {
        return cFunctionName;
    }

    public void setcFunctionName(String cFunctionName) {
        this.cFunctionName = cFunctionName;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "cTypeName='" + cTypeName + '\'' +
                ", cFunctionName='" + cFunctionName + '\'' +
                '}';
    }
}
