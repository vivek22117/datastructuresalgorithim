package com.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by Vivek Kumar Mishra on 27/09/2018.
 */
public class FilterEmployee {


    private List<EmpAddress> addresseList;
    private List<EmpDept> deptList;

    public FilterEmployee(List<EmpAddress> addresseList, List<EmpDept> deptList) {
        this.addresseList = addresseList;
        this.deptList = deptList;
    }

    public FilterEmployee() {
    }

    public List<EmpAddress> getAddresseList() {
        return addresseList;
    }

    public void setAddresseList(List<EmpAddress> addresseList) {
        this.addresseList = addresseList;
    }

    public List<EmpDept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<EmpDept> deptList) {
        this.deptList = deptList;
    }

    @Override
    public String toString() {
        return "FilterEmployee{" +
                "addresseList=" + addresseList +
                ", deptList=" + deptList +
                '}';
    }

    public void filterEmployees(List<FilterEmployee> diffEmployes){
        List<FilterEmployee> filteredList = new ArrayList<>();

        IntStream.iterate(0, e->e+1).limit(diffEmployes.size()).forEach(e -> {
        Map<Boolean, List<EmpAddress>> mumbai = diffEmployes.get(e).getAddresseList()
                .parallelStream().collect(partitioningBy(address -> address.getCity().equals("Mumbai")));
        Map<Boolean, List<EmpDept>> bb = diffEmployes.get(e).getDeptList()
                .parallelStream().collect(partitioningBy(dept -> dept.getDeptName().equals("BB")));

        if(mumbai.get(true).size() > 0 && bb.get(true).size() > 0){
            filteredList.add(diffEmployes.get(e));
        }
        });

      filteredList.forEach(System.out::println);

    }

    public static void main(String[] args) {

         List<FilterEmployee> diffEmployes =  Arrays.asList(new FilterEmployee(EmpAddress.addresses1, EmpDept.dept1),
                new FilterEmployee(EmpAddress.addresses2, EmpDept.dept2),
                new FilterEmployee(EmpAddress.addresses3, EmpDept.dept3));

        FilterEmployee employee = new FilterEmployee();
        employee.filterEmployees(diffEmployes);
    }





    public static class EmpAddress{

        public EmpAddress() {
        }

        private String city;
        private String state;

        public EmpAddress(String city, String state) {
            this.city = city;
            this.state = state;
        }

        public static List<EmpAddress> addresses1 = Arrays.asList(new EmpAddress("Mumbai", "MH"),new EmpAddress("Nagpur", "MH" ));
        public static List<EmpAddress> addresses2 = Arrays.asList(new EmpAddress("Jabalpur", "MP"),new EmpAddress("Pune", "MH"));
        public static List<EmpAddress> addresses3 = Arrays.asList(new EmpAddress("Mumbai", "MP"),new EmpAddress("indore", "MP" ));


        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "EmpAddress{" +
                    "city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    '}';
        }
    }

    public static class EmpDept{

        private String deptName;
        private Integer deptId;

        public EmpDept(String deptName, Integer deptId) {
            this.deptName = deptName;
            this.deptId = deptId;
        }

        public EmpDept() {
        }

        public  static List<EmpDept> dept1 = Arrays.asList(new EmpDept("AA", 501),new EmpDept("BB", 502));
        public  static List<EmpDept> dept2 = Arrays.asList(new EmpDept("CC", 503),new EmpDept("BB", 502));
        public  static List<EmpDept> dept3 = Arrays.asList(new EmpDept("B", 502),new EmpDept("DD", 504));


        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public Integer getDeptId() {
            return deptId;
        }

        public void setDeptId(Integer deptId) {
            this.deptId = deptId;
        }

        @Override
        public String toString() {
            return "EmpDept{" +
                    "deptName='" + deptName + '\'' +
                    ", deptId=" + deptId +
                    '}';
        }
    }
}
