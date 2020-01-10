package com.doubledigit.algorithim.chapter1.datastructures;

import java.util.Arrays;
import java.util.Objects;

public class TestDataStructures {


    public static void main(String[] args) throws LinkListDSWithHeadAndTail.LinkListUnderFlowException {
        LinkListDSWithHeadAndTail<Machine> listOfMachines = new LinkListDSWithHeadAndTail<>();

        System.out.println(listOfMachines.getSize());

        listOfMachines.append(new Machine(44, false));
        listOfMachines.append(new Machine(22, false));
        listOfMachines.append(new Machine(55, false));

        System.out.println(listOfMachines.getSize());

        System.out.println(listOfMachines.indexOf(new Machine(22, false)));

        listOfMachines.prepend(new Machine(11, true));

        System.out.println(listOfMachines.contains(new Machine(66, false)));
        System.out.println(listOfMachines.getSize());

        listOfMachines.removeLast();
        System.out.println(listOfMachines.getSize());

        Machine[] machines = (Machine[]) listOfMachines.toArray();
        System.out.println(Arrays.toString(machines));

    }




    static class Machine {
        int Id;
        boolean isActive;

        public Machine(int id, boolean isActive) {
            Id = id;
            this.isActive = isActive;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Machine machine = (Machine) o;
            return Id == machine.Id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(Id);
        }

        @Override
        public String toString() {
            return "Machine{" +
                    "Id=" + Id +
                    ", isActive=" + isActive +
                    '}';
        }
    }
}
