package com.cxp.module_girls.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.cxp.lib_common.bean.ResultsBean;
import com.cxp.lib_common.listener.OnItemClickListenter;
import com.cxp.lib_common.utils.AppUtils;
import com.cxp.module_girls.R;
import com.cxp.module_girls.databinding.ItemGirlsDataBinding;

import java.util.List;

/**
 * 文 件 名: GirlsAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-05-29 14:58
 * 描    述: 新闻适配器
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class GirlsAdapter extends RecyclerView.Adapter<GirlsAdapter.GirlsViewHolder> {

    private List<ResultsBean> girlsList;
    private OnItemClickListenter mOnItemClickListenter;

    /**
     * 构造方法传入点击监听器
     * @param onItemClickListenter
     */
    public GirlsAdapter(@Nullable OnItemClickListenter onItemClickListenter) {
        mOnItemClickListenter = onItemClickListenter;
    }

    public void setGirlsList(final List<ResultsBean> list){
        if(girlsList == null){
            girlsList = list;
            notifyItemRangeInserted(0, girlsList.size());
        }else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return girlsList.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    ResultsBean oldData = girlsList.get(oldItemPosition);
                    ResultsBean newData = list.get(newItemPosition);
                    return oldData.get_id() == newData.get_id();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    ResultsBean oldData = girlsList.get(oldItemPosition);
                    ResultsBean newData = list.get(newItemPosition);
                    return oldData.get_id() == newData.get_id()
                            && oldData.getCreatedAt() == newData.getCreatedAt()
                            && oldData.getPublishedAt() == newData.getPublishedAt()
                            && oldData.getSource() == newData.getSource();
                }
            });
            girlsList = list;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public GirlsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGirlsDataBinding dataBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item_girls,
                parent, false);
        dataBinding.setCallback(mOnItemClickListenter);
        return new GirlsViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(GirlsViewHolder holder, int position) {
        //图片显示
        Glide.with(AppUtils.getContext())
                .load(girlsList.get(position).getUrl())
                .into(holder.dataBinding.itemGirlsImg);

        holder.dataBinding.setGirlsItem(girlsList.get(position));
        //强制刷新
        holder.dataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return girlsList == null ? 0 : girlsList.size();
    }

    public class GirlsViewHolder extends RecyclerView.ViewHolder{

        ItemGirlsDataBinding dataBinding;

        public GirlsViewHolder(ItemGirlsDataBinding binding) {
            super(binding.getRoot());
            this.dataBinding = binding;
        }
    }
}
