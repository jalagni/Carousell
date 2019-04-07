package com.carousell.appCallBack;


import com.carousell.data.dataModel.ArticleModel;
import com.carousell.domain.domainModel.Article;

import java.util.Comparator;

public class SortComparator implements Comparator<Article> {

    public enum TYPE{
        DATE,
        POPULAR
    }

    private TYPE cType = TYPE.DATE;


    @Override
    public int compare(Article a1, Article a2) {

        switch (cType){
            case DATE:
                return a2.getTime_created() - a1.getTime_created() ;
            case POPULAR:
                int diff = a1.getRank() - a2.getRank();
                return (diff != 0) ? diff: a2.getTime_created() - a1.getTime_created() ;
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
