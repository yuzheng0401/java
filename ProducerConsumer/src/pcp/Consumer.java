package pcp;

/** 
 * ��������Consumer�̳��߳���Thread 
 *  
 * Email:530025983@qq.com 
 *  
 * @author MONKEY.D.MENG 2011-03-15 
 *  
 */  
public class Consumer extends Thread  
{  
    // ÿ�����ѵĲ�Ʒ����  
    private int num;  
  
    // ���ڷ��õĲֿ�  
    private Storage storage;  
  
    // ���캯�������òֿ�  
    public Consumer(Storage storage)  
    {  
        this.storage = storage;  
    }  
  
    // �߳�run����  
    public void run()  
    {  
        consume(num);  
    }  
  
    // ���òֿ�Storage����������  
    public void consume(int num)  
    {  
        storage.consume(num);  
    }  
  
    // get/set����  
    public int getNum()  
    {  
        return num;  
    }  
  
    public void setNum(int num)  
    {  
        this.num = num;  
    }  
  
    public Storage getStorage()  
    {  
        return storage;  
    }  
  
    public void setStorage(Storage storage)  
    {  
        this.storage = storage;  
    }  
}  