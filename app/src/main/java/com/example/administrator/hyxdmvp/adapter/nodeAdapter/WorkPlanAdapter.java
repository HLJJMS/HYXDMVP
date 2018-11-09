package com.example.administrator.hyxdmvp.adapter.nodeAdapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.base.DropDownView;
import com.example.administrator.hyxdmvp.base.tool.CompoundUrlForHome;
import com.example.administrator.hyxdmvp.bean.DropDownItem;
import com.example.administrator.hyxdmvp.bean.list.WorkPlanBean;
import com.example.administrator.hyxdmvp.fragment.view.home.HomeFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class WorkPlanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<WorkPlanBean.MyDynamicDataBean> bean = new ArrayList<>();
    private int realPostion = 0;
    private CompoundUrlForHome tools = new CompoundUrlForHome();
    private ArrayAdapter<String> arrAdapter;
    private HomeFragment fragment;
    private Context context;
    private Calendar ca = Calendar.getInstance();
    private int mYear, mMonth, mDay;
    private String startDay = "1970-01-01", endDay = "2100-01-01";
    private StringBuffer day = new StringBuffer().append(startDay).append(",").append(endDay);
    private LinkedList<DropDownItem> mData = new LinkedList<DropDownItem>();
    ;

    public WorkPlanAdapter(HomeFragment fragment, Context context) {
        this.fragment = fragment;
        this.context = context;
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
    }

    public void setDownList(LinkedList<DropDownItem> mData) {
        this.mData.clear();
        this.mData.addAll(mData);
    }

    public void setData(List<WorkPlanBean.MyDynamicDataBean> bean) {
        this.bean.clear();
        this.bean.addAll(bean);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.title_work_plan_search, viewGroup, false));
        } else if (i == bean.size() + 1) {
            return new FootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_end_sum, viewGroup, false));
        } else {
            return new BodyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_work_paln, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        Log.e("max", String.valueOf(i));
        realPostion = i - 1;
        if (i == 0) {
            ((HeaderViewHolder) viewHolder).downView.setmData(mData);
            ((HeaderViewHolder) viewHolder).timeStart.setText(startDay);
            ((HeaderViewHolder) viewHolder).timeEnd.setText(endDay);

            ((HeaderViewHolder) viewHolder).timeStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(context, onStartDateSetListener, mYear, mMonth, mDay).show();
                }
            });
            ((HeaderViewHolder) viewHolder).timeEnd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(context, onEndDateSetListener, mYear, mMonth, mDay).show();
                }
            });
            ((HeaderViewHolder) viewHolder).search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.getRecyclerData("M000181",tools.searchWorkPlan(((HeaderViewHolder) viewHolder).downView.getValue(),startDay,endDay));
                }
            });
            ((HeaderViewHolder) viewHolder).reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragment.getRecyclerData("M000181","");
                }
            });

        } else if (i == bean.size() +1) {
            ((FootViewHolder) viewHolder).max.setText(new StringBuffer().append("共").append(bean.size()).append("条数据").toString());
        } else {
            ((BodyViewHolder) viewHolder).oneOne.setText(bean.get(realPostion).getF0004());
            ((BodyViewHolder) viewHolder).twoOne.setText(String.valueOf(bean.get(realPostion).getF0009()));
            ((BodyViewHolder) viewHolder).oneTwo.setText(bean.get(realPostion).getF0010());
            ((BodyViewHolder) viewHolder).twoTwo.setText(bean.get(realPostion).getF0012().substring(0, 10));
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
    }

    //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView timeStart, timeEnd;
        private ImageView search, reset;
        private DropDownView downView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            timeStart = (TextView) itemView.findViewById(R.id.time_start);
            timeEnd = (TextView) itemView.findViewById(R.id.time_end);
            reset = (ImageView) itemView.findViewById(R.id.reset);
            search = (ImageView) itemView.findViewById(R.id.search);
            downView = (DropDownView) itemView.findViewById(R.id.drop_down_view);

        }
    }

    //身体的ViewHolder
    public class BodyViewHolder extends RecyclerView.ViewHolder {
        private TextView oneOne, twoTwo, oneTwo, twoOne;

        public BodyViewHolder(@NonNull View itemView) {
            super(itemView);
            oneOne = (TextView) itemView.findViewById(R.id.oneone);
            twoTwo = (TextView) itemView.findViewById(R.id.twotwo);
            oneTwo = (TextView) itemView.findViewById(R.id.onetwo);
            twoOne = (TextView) itemView.findViewById(R.id.twoone);
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

    //选择开始日期
    private DatePickerDialog.OnDateSetListener onStartDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {

                    startDay = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {

                    startDay = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append(mDay).toString();
                }

            } else {
                if (mDay < 10) {

                    startDay = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {

                    startDay = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append(mDay).toString();

                }

            }
            installDate();
            notifyItemChanged(0);
        }
    };
    //    选择结束日期
    private DatePickerDialog.OnDateSetListener onEndDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            if (mMonth + 1 < 10) {
                if (mDay < 10) {

                    endDay = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {

                    endDay = new StringBuffer().append(mYear).append("-").append("0").
                            append(mMonth + 1).append("-").append(mDay).toString();
                }

            } else {
                if (mDay < 10) {

                    endDay = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append("0").append(mDay).toString();
                } else {

                    endDay = new StringBuffer().append(mYear).append("-").
                            append(mMonth + 1).append("-").append(mDay).toString();

                }

            }
            installDate();
            notifyItemChanged(0);
        }
    };

    private void installDate() {
        day.append(startDay).append(",").append(endDay);
    }
}
