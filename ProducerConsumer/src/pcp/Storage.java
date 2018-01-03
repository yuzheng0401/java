package pcp;
import java.util.LinkedList;  
  
/** 
 * �ֿ���Storageʵ�ֻ����� 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-15 
 *  
 */  
public class Storage  
{  
    // �ֿ����洢��  
    private final int MAX_SIZE = 100;  
  
    // �ֿ�洢������  
    private LinkedList<Object> list = new LinkedList<Object>();  
  
    // ����num����Ʒ  
    public void produce(int num)  
    {  
        // ͬ�������  
        synchronized (list)  
        {  
            // ����ֿ�ʣ����������  
            while (list.size() + num > MAX_SIZE)  
            {  
                System.out.println("��Ҫ�����Ĳ�Ʒ������:" + num + "/t���������:"  
                        + list.size() + "/t��ʱ����ִ����������!");  
                try  
                {  
                    // �������������㣬��������  
                    list.wait();  
                }  
                catch (InterruptedException e)  
                {  
                    e.printStackTrace();  
                }  
            }  
  
            // ����������������£�����num����Ʒ  
            for (int i = 1; i <= num; ++i)  
            {  
                list.add(new Object());  
            }  
  
            System.out.println("���Ѿ�������Ʒ����:" + num + "/t���ֲִ���Ϊ��:" + list.size());  
  
            list.notifyAll();  
        }  
    }  
  
    // ����num����Ʒ  
    public void consume(int num)  
    {  
        // ͬ�������  
        synchronized (list)  
        {  
            // ����ֿ�洢������  
            while (list.size() < num)  
            {  
                System.out.println("��Ҫ���ѵĲ�Ʒ������:" + num + "/t���������:"  
                        + list.size() + "/t��ʱ����ִ����������!");  
                try  
                {  
                    // �������������㣬��������  
                    list.wait();  
                }  
                catch (InterruptedException e)  
                {  
                    e.printStackTrace();  
                }  
            }  
  
            // ����������������£�����num����Ʒ  
            for (int i = 1; i <= num; ++i)  
            {  
                list.remove();  
            }  
  
            System.out.println("���Ѿ����Ѳ�Ʒ����:" + num + "/t���ֲִ���Ϊ��:" + list.size());  
  
            list.notifyAll();  
        }  
    }  
  
    // get/set����  
    public LinkedList<Object> getList()  
    {  
        return list;  
    }  
  
    public void setList(LinkedList<Object> list)  
    {  
        this.list = list;  
    }  
  
    public int getMAX_SIZE()  
    {  
        return MAX_SIZE;  
    }  
}  
