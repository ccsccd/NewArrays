import java.util.Arrays;

public class NewArray<T> {
    private Object[] elementData;
    private int size=0;
    //默认初始容量为10
    public NewArray(){
        elementData=new Object[10];
    }
    //自定义初始容量
    public NewArray(int length){
        elementData=new Object[length];
    }
    //正序添加(增)
    public void add(T element){
        expand(size+1);
        elementData[size++]=element;
    }
    //插入添加(增)
    public void add(int index, T element) {
        expand(size+1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }
    //容量不够自动扩充
    private void expand(int num) {
        if (size == elementData.length) {
            Object[] arr = new Object[((size * 3) / 2) + 1];//自动扩容(根据ArrayList的算法扩充)
            System.arraycopy(elementData, 0, arr, 0, size);
            elementData = arr;
        }
    }
    //删除某个元素(删)
    public void remove(int index){
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        elementData[--size] = null;
    }
    //范围删除(删)
    public void remove(int fromIndex, int toIndex) {
        int numMoved = size - toIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex,numMoved);
        int newSize = size - (toIndex-fromIndex);
        for (int i = newSize; i < size; i++) {
            elementData[i] = null;
        }
        size = newSize;
    }
    //获取某个元素(查)
    public T getElement(int index){
        return (T)elementData[index];
    }
    //查询是否存在某个元素(查)
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    //修改某个元素(改)
    public void set(int index,T element){
        elementData[index]=element;
    }
    //获取容器长度
    public int getSize(){
        return size;
    }
    //重写toString
    @Override
    public String toString() {
        Object[] arr = new Object[size];
        System.arraycopy(elementData, 0, arr, 0, size);
        return Arrays.toString(arr);
    }
    //遍历容器内的元素并输出
    public void forEach() {
        for (int i=0;i < size; i++) {
            System.out.println(elementData[i]);
        }
    }
    //判断容器是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    //清空所有元素
    public void clear() {
     //   modCount++;
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }



}
