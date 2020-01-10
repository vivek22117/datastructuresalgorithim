package com.doubledigit.algorithim.chapter1.linklistquestions;

import com.doubledigit.algorithim.chapter1.datastructures.LinkListDataStructure;

public class LinkListImplementationForMachine {

    public class Machine {
        private long machineId;
        private String machineType;
        private String machineName;

        public Machine(long machineId, String machineType, String machineName) {
            this.machineId = machineId;
            this.machineType = machineType;
            this.machineName = machineName;
        }
    }

    LinkListDataStructure<Machine> machineLinkList = new LinkListDataStructure<>();



    public void addNewMachine(Machine machine){
        machineLinkList.append(machine);
    }

    public void getHead(){
        machineLinkList.getHead();
    }


    public void deleteMachine(Machine machine){
        machineLinkList.delete(machine);
    }

}
