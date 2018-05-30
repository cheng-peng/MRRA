package com.cxp.module_news.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cxp.lib_common.bean.ResultsBean;
import com.cxp.lib_common.listener.OnItemClickListenter;
import com.cxp.module_news.R;
import com.cxp.module_news.databinding.ItemNewsDataBinding;

import java.util.List;

/**
 * 文 件 名: NewsAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-05-29 14:58
 * 描    述: 新闻适配器
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<ResultsBean> newsList;
    private OnItemClickListenter mOnItemClickListenter;

    /**
     * 构造方法传入点击监听器
     * @param onItemClickListenter
     */
    public NewsAdapter(@Nullable OnItemClickListenter onItemClickListenter) {
        mOnItemClickListenter = onItemClickListenter;
    }

    public void setNewsList(final List<ResultsBean> list){
        if(newsList == null){
            newsList = list;
            notifyItemRangeInserted(0, newsList.size());
        }else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return newsList.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    ResultsBean oldData = newsList.get(oldItemPosition);
                    ResultsBean newData = list.get(newItemPosition);
                    return oldData.get_id() == newData.get_id();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    ResultsBean oldData = newsList.get(oldItemPosition);
                    ResultsBean newData = list.get(newItemPosition);
                    return oldData.get_id() == newData.get_id()
                            && oldData.getCreatedAt() == newData.getCreatedAt()
                            && oldData.getPublishedAt() == newData.getPublishedAt()
                            && oldData.getSource() == newData.getSource();
                }
            });
            newsList = list;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsDataBinding dataBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item_news,
                parent, false);
        dataBinding.setCallback(mOnItemClickListenter);
        return new NewsViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.dataBinding.setNewsItem(newsList.get(position));
        holder.dataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return newsList == null ? 0 : newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ItemNewsDataBinding dataBinding;

        public NewsViewHolder(ItemNewsDataBinding binding ) {
            super(binding.getRoot());
            this.dataBinding = binding;
        }
    }
}
