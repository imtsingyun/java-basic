package org.mindidea.design.d5prototype.deepCopy;

import java.io.*;

public class DeepPerson implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    public String name;

    public Person person;

    @Override
    public String toString() {
        return "DeepPerson{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }

    // 深拷贝，方式1 使用 clone 方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deepPerson;
        deepPerson = super.clone();
        DeepPerson d = (DeepPerson) deepPerson;
        d.person = (Person) person.clone();
        return d;
    }

    // 深拷贝，方式2:使用对象序列化实现
    public Object deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 将当前对象以对象流的方式输出
            oos.writeObject(this);

            // 反序列
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert bos != null;
                bos.close();
                assert oos != null;
                oos.close();
                assert bis != null;
                bis.close();
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
