package com.carousell.appCallBack;


import com.carousell.data.dataModel.ArticleModel;

import java.util.Comparator;

public class SortComparator implements Comparator<ArticleModel> {

    public enum TYPE{
        DATE,
        POPULAR
    }

    private TYPE cType = TYPE.DATE;


    @Override
    public int compare(ArticleModel a1, ArticleModel a2) {

        switch (cType){
            case DATE:
                return a1.getTime_created() - a2.getTime_created() ;
            case POPULAR:
                int diff = a1.getRank() - a2.getRank();
                return (diff != 0) ? diff: a1.getTime_created() - a2.getTime_created() ;
        }

        return 0;
    }

    public TYPE getCompareType() {
        return cType;
    }

    public void setCompareType(TYPE cType) {
        this.cType = cType;
    }
}
