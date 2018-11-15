package com.example.administrator.hyxdmvp.adapter.nodeAdapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.tool.CompoundUrlForHome;
import com.example.administrator.hyxdmvp.bean.UserManagerBean;
import com.example.administrator.hyxdmvp.fragment.view.home.HomeFragment;
import com.example.administrator.hyxdmvp.ui.view.UserDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class UserManageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<UserManagerBean.MyDynamicDataBean> bean = new ArrayList<>();
    private CompoundUrlForHome tools = new CompoundUrlForHome();
    private HomeFragment fragment;
    private int realPostion;

    public UserManageAdapter(HomeFragment fragment) {
        this.fragment = fragment;
    }

    public void setData(List<UserManagerBean.MyDynamicDataBean> bean) {
        this.bean.clear();
        this.bean.addAll(bean);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == bean.size()+1) {
            return new FootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_end_sum, viewGroup, false));
        } else
            if (i == 0) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.title_user_manager_search, viewGroup, false));
        } else {
            return new BodyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_manage, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        realPostion = i - 1;
        if (i == bean.size() +1) {
            ((FootViewHolder) viewHolder).max.setText(new StringBuffer().append("共").append(bean.size()).append("条数据").toString());
        }
        else
            if (i == 0) {
            ((HeaderViewHolder) viewHolder).search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.getRecyclerData("M000118",tools.searchUserManagerData(((HeaderViewHolder) viewHolder).name.getText().toString(), ((HeaderViewHolder) viewHolder).department.getText().toString(), ((HeaderViewHolder) viewHolder).position.getText().toString()));
                }
            });
            ((HeaderViewHolder) viewHolder).reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.getRecyclerData("M000118","");
                }
            });
        }
        else {
            ((BodyViewHolder) viewHolder).id.setText(bean.get(realPostion).getF0002());
            ((BodyViewHolder) viewHolder).name.setText(bean.get(realPostion).getF0003());
            ((BodyViewHolder) viewHolder).department.setText(bean.get(realPostion).getF0024());
            ((BodyViewHolder) viewHolder).type.setText(bean.get(realPostion).getF0087());
            ((BodyViewHolder) viewHolder).tel.setText(bean.get(realPostion).getF0032());
            ((BodyViewHolder) viewHolder).position.setText(bean.get(realPostion).getF0054());
                ((BodyViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("位置",String.valueOf(i));
                        Intent intent = new Intent();
                        intent.putExtra("id",bean.get(i-1).getF0002());
                        intent.setClass(fragment.getContext(),UserDetailActivity.class);
                        fragment.startActivity(intent);
                    }
                });
        }

    }

    //    他的返回值直接影响RecyclerView.ViewHolder里面的int值
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return bean.size() + 2;
//        return bean.size()+1;
    }

    //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private EditText name, department, position;

        private ImageView search, reset;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            name = (EditText) itemView.findViewById(R.id.name);
            department = (EditText) itemView.findViewById(R.id.department);
            reset = (ImageView) itemView.findViewById(R.id.reset);
            search = (ImageView) itemView.findViewById(R.id.search);
            position = (EditText) itemView.findViewById(R.id.position);

        }
    }

    //尾巴的ViewHolder
    public class FootViewHolder extends RecyclerView.ViewHolder {
        private TextView max;

        public FootViewHolder(@NonNull View itemView) {
            super(itemView);
            max = (TextView) itemView.findViewById(R.id.max);

        }
    }

    public class BodyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, department, tel, id, type, position;

        public BodyViewHolder(@NonNull View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.type);
            id = (TextView) itemView.findViewById(R.id.id);
            tel = (TextView) itemView.findViewById(R.id.tel);
            department = (TextView) itemView.findViewById(R.id.department);
            name = (TextView) itemView.findViewById(R.id.name);
            position = (TextView) itemView.findViewById(R.id.position);

        }
    }
}
