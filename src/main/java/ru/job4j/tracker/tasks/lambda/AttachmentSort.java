package ru.job4j.tracker.tasks.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparatorBySize =  new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {

                return o1.getSize() - o2.getSize();

            }
        };
        attachments.sort(comparatorBySize);
        System.out.println(attachments);
        Comparator<Attachment> comparatorByName = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(comparatorByName);
        System.out.println(attachments);
    }
}