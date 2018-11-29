public class Main {
    public static void main(String[] args) {
        NewArray my = new NewArray();
        my.add(0);
        my.add("一");
        my.add(2);
        my.add("三");
        my.add(4);
        my.add("五");
        my.add(6);
        my.add("七");
        my.add(8);
        System.out.println(my);
        System.out.println("容器长度为：" + my.getSize());

        my.set(1,"①");
        System.out.println(my);
        System.out.println("容器长度为：" + my.getSize());

        my.add(2,999);
        my.add(2,999);
        my.add(2,999);
        my.add(2,999);
        System.out.println(my);
        System.out.println("容器长度为：" + my.getSize());

        my.remove(2);
        System.out.println(my);
        System.out.println("容器长度为：" + my.getSize());

        my.remove(2,5);
        System.out.println(my);
        System.out.println("容器长度为：" + my.getSize());

        System.out.println(my.getElement(5));

        System.out.println(my.contains("九"));

        my.forEach();

        my.clear();
        System.out.println(my);
        System.out.println("容器长度为：" + my.getSize());

        System.out.println(my.isEmpty());
    }
}
