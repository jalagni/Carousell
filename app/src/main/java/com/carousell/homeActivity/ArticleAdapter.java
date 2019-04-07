package com.carousell.homeActivity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.carousell.R;
import com.carousell.appCallBack.ListCallBack;
import com.carousell.appCallBack.SortComparator;
import com.carousell.data.dataModel.ArticleModel;
import com.carousell.databinding.LayoutArticleBinding;
import com.carousell.domain.domainModel.Article;
import com.carousell.utils.AppUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleHolder> {

    SortComparator sortComparator = new SortComparator();
    private ArrayList<Article> articleList = new ArrayList();
    private ListCallBack listCall;

    public ArticleAdapter(ListCallBack listCall) {
        this.listCall = listCall;
    }

    public void setComparator(SortComparator.TYPE sType) {

        if (sortComparator.getCompareType() == sType) {
            Timber.e("Compare type is already selected: " + sType);
            return;
        }

        sortComparator.setCompareType(sType);
        Collections.sort(articleList, sortComparator);
        notifyDataSetChanged();

        Timber.e("Sort: ");
        printContent();
    }

    private void printContent() {
        Timber.e("---------------");

        for (Article aModel : articleList) {
            Timber.e(aModel.getTitle());
        }
    }

    public void setContent(ArrayList<Article> arrayList) {
        this.articleList = arrayList;
        Collections.sort(articleList, sortComparator);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int vType) {

        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutArticleBinding lBinding = LayoutArticleBinding.inflate(inflater, viewGroup, false);
        ArticleHolder holder = new ArticleHolder(lBinding);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder articleHolder, int position) {

        Article aModel = getItem(position);

        Picasso.get().load(aModel.getBanner_url())
                .into(articleHolder.lBinding.iBanner);


       // Context context = articleHolder.lBinding.iBanner.getContext();

        articleHolder.lBinding.tTitle.setText(aModel.getTitle());
        articleHolder.lBinding.tDesc.setText(aModel.getDescription());

        articleHolder.lBinding.tDate.setText(aModel.getFormateDate());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public Article getItem(int position) {
        return articleList.get(position);
    }


}

class ArticleHolder extends RecyclerView.ViewHolder {
    protected LayoutArticleBinding lBinding;

    public ArticleHolder(@NonNull LayoutArticleBinding binding) {

        super(binding.getRoot());
        this.lBinding = binding;
    }
}
