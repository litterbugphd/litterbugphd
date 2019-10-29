package com.e.litterfirebase;


import java.util.List;

public class NopeObject {

    private String name;
    private int listImage;
    private int selectedAnswerPosition;
    private boolean op1Sel, op2Sel, op3Sel, op4Sel, op5Sel, op6Sel; // options

    public NopeObject() {
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getListImage() {
        return listImage;
    }

    public void setListImage(int listImage) {
        this.listImage = listImage;

    }

    public boolean isOp1Sel() {
        return op1Sel;
    }

    public void setOp1Sel(boolean op1Sel) {
        this.op1Sel = op1Sel;
        if (op1Sel) { // To make sure only one option is selected at a time
            setOp2Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
            setOp5Sel(false);
            setOp6Sel(false);

        }
    }

    public boolean isOp2Sel() {
        return op2Sel;
    }

    public void setOp2Sel(boolean op2Sel) {
        this.op2Sel = op2Sel;
        if (op2Sel) {
            setOp1Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
            setOp5Sel(false);
            setOp6Sel(false);

        }
    }

    public boolean isOp3Sel() {
        return op3Sel;
    }

    public void setOp3Sel(boolean op3Sel) {
        this.op3Sel = op3Sel;
        if (op3Sel) {
            setOp2Sel(false);
            setOp1Sel(false);
            setOp4Sel(false);
            setOp5Sel(false);
            setOp6Sel(false);

        }
    }

    public boolean isOp4Sel() {
        return op4Sel;
    }

    public void setOp4Sel(boolean op4Sel) {
        this.op4Sel = op4Sel;
        if (op4Sel) { // To make sure only one option is selected at a time
            setOp2Sel(false);
            setOp3Sel(false);
            setOp5Sel(false);
            setOp6Sel(false);
            setOp1Sel(false);

        }
    }

    public boolean isOp5Sel() {
        return op5Sel;
    }

    public void setOp5Sel(boolean op5Sel) {
        this.op5Sel = op5Sel;
        if (op5Sel) {
            setOp1Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
            setOp6Sel(false);
            setOp2Sel(false);
        }
    }

    public boolean isOp6Sel() {
        return op6Sel;
    }

    public void setOp6Sel(boolean op6Sel) {
        this.op6Sel = op6Sel;
        if (op6Sel) {
            setOp2Sel(false);
            setOp1Sel(false);
            setOp5Sel(false);
            setOp3Sel(false);
            setOp4Sel(false);
        }
    }

    public int getSelectedAnswerPosition() {
        return selectedAnswerPosition;
    }

    public void setSelectedAnswerPosition(int selectedAnswerPosition) {
        this.selectedAnswerPosition = selectedAnswerPosition;
    }

}




