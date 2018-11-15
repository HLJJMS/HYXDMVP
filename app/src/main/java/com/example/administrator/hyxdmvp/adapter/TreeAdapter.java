package com.example.administrator.hyxdmvp.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.tool.TreeHelper;
import com.example.administrator.hyxdmvp.bean.MenuTreeBean;
import com.example.administrator.hyxdmvp.fragment.view.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.viewHolder> {
    private List<MenuTreeBean.MyDynamicDataBean> showNode = new ArrayList<>();
    private TreeHelper treeHelper = new TreeHelper();
    private View view;
    private HomeFragment activity;
    public TreeAdapter(HomeFragment activity) {
        this.activity = activity;
    }

    //插入数据
    public void setData(List<MenuTreeBean.MyDynamicDataBean> node) {
        showNode.clear();
        showNode.addAll(treeHelper.getRoot(node));
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TreeAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tree, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TreeAdapter.viewHolder viewHolder, final int i) {
        viewHolder.itemView.setPadding(showNode.get(i).getF0010() * 30, 3, 3, 3);
        viewHolder.text.setText(showNode.get(i).getF0006());
        if(showNode.get(i).getF0010()==0){
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#00000000"));
            viewHolder.icon.setVisibility(View.VISIBLE);
            if(showNode.get(i).isShowChild() == false){
                viewHolder.icon.setText("☞");
            }else{
                viewHolder.icon.setText("☟");
            }
        }else{
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#22000000"));
            viewHolder.icon.setVisibility(View.INVISIBLE);

        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showNode.get(i).getF0010()==0){
                    if (showNode.get(i).isShowChild() == false) {
                        showNode.get(i).setShowChild(true);
                        showChild(showNode.get(i).getF0005(), i);
                    } else {
                        showNode.get(i).setShowChild(false);
                        closeChild(showNode.get(i).getF0005(), i);
                    }
                }else{
                    activity.closeDrawerLayout();
                    activity.getRecyclerData(showNode.get(i).getF0012(),"");
                }

            }
        });
    }
//    点击父亲节点现实子节点
    private void showChild(String id, int position) {
        showNode.addAll(position + 1, treeHelper.getChild(id));
        notifyDataSetChanged();
    }
//    点击父亲节点隐藏子节点
    private void closeChild(String id, int position) {
        while (position + 1 < showNode.size()) {
            if (showNode.get(position + 1).getF0003().equals(id)) {
                showNode.remove(position + 1);
            } else {
                break;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return showNode.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public TextView icon;
        public viewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.title);
            icon =(TextView) itemView.findViewById(R.id.icon);
        }
    }
}
