package com.example.administrator.hyxdmvp.base.tool;

public class CompoundUrlForHome {
    //    搜索计划列表
    public String searchWorkPlan(String name, String startDay,String endDay) {
      if(!"".equals(name)&&null!=name){
          name = "|10::" + name;
      }else{
          name ="";
      }
        return  new StringBuffer().append(name).append("|12>>::").append(startDay).append("|12<<::").append(endDay).toString();
    }

    //    搜索员工列表
    public String  searchUserManagerData(String name, String department, String position) {
        if (!name.equals("")) {
            name = "|3::" + name;
        }
        if (!department.equals("")) {
            department = "|24::" + department;
        }
        if (!position.equals("")) {
            position = "|54::" + position;
        }
        return new StringBuffer().append(name).append(department).append(position).toString();
    }
}
