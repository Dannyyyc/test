package Test;
import java.util.*;
/**
 * �Ի����˿���̨���ϵͳ
 * @author Danny
 *
 */
//����һ��
public class OrderMsg {
	public static void main(String[] args) {
		//����  һ�鶩����Ϣ
		String[] userName = new String[5];//�洢�û�����
		String[] dishMsg = new String[5];//��Ʒ��Ϣ
		int[] times = new int[5];//�Ͳ�ʱ��
		String[] adress = new String[5];//�Ͳ͵�ַ
		int[] States = new int[5];//����״̬ 1������� 0����Ԥ��
		double[] sumPrice = new double[5];//�ܽ��
		//��ʼ��
		userName[0] = "����";
		dishMsg[0] = "������  2��";
		times[0] = 12;
		adress[0] = "�ൺ·";
		sumPrice[0] = 36;
		States[0] = 0;

		//��������  һ���Ʒ��Ϣ
		String[] dishName = {"���մ���","������","ը����","���׷�","С����"};
		double[] price ={15.5,26.3,30.5,10,20};
		int[] praiseNum = new int[5];
		 //������
		int num = -1;
		do{
			System.out.println("**********************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("**********************");
			System.out.print("��ѡ��");			
			Scanner sc = new Scanner(System.in);
			int choose =sc.nextInt();
			switch(choose){
			case 1:
				//��Ҫ���
				System.out.println("*****��Ҫ����*****");
				boolean isAdd = false;
				for(int i=0;i<userName.length;i++){
					//�ҵ�Ҫ�����λ��
					if(userName[i]==null){
						//��¼���ҵ�����Ϊ�յ�λ��
						isAdd = true;
						System.out.println("���\t����\t����\t������");
						for(int j=1;j<=dishName.length;j++){
							System.out.println(j+".\t"+dishName[j-1]+"\t"+price[j-1]+"\t"+praiseNum[j-1]+"��");
						}
						System.out.println("��ѡ����Ҫ��Ĳ�Ʒ��ţ�");
						int chooseDish = sc.nextInt();
						System.out.println("��������Ҫ������");
						int number = sc.nextInt();
						System.out.println("�����붩����������");
						String name = sc.next();
						System.out.println("�������Ͳ�ʱ�䣨10��~20�������Ͳͣ���");
						int time=sc.nextInt();
						while(time<10||time>20){
								System.out.println("��������ȷ��ʱ�䣡");
								time=sc.nextInt();
							}
						System.out.println("�������Ͳ͵ص㣺");
						String Adress = sc.next();
						//����ͷ�
						double sum= price[chooseDish-1]*number;
						//���ͷѴ���50Ԫ����6Ԫ�Ͳͷ�
						double songCanFei = sum > 50 ? 0.0 : 6.0;
						System.out.println("���ͳɹ���");
						System.out.println("�������ǣ�"+dishName[chooseDish-1]+" "+number+"��");
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�ͷѣ�"+sum+"Ԫ"+"  �Ͳͷѣ�"+songCanFei+"Ԫ");
						System.out.println("�ܶ"+(sum+songCanFei)+"Ԫ");
						userName[i]=name;
						dishMsg[i]=dishName[chooseDish-1]+number+"��";
						times[i] = time;
						adress[i] = Adress;
						sumPrice[i] = sum+songCanFei;
						States[i]= 0;
						break;
					}
				}
				//���û���ҵ���λ�ã���ʾ��Ϣ
				if(!isAdd){
					System.out.println("������˼�����Ĳʹ�������");
				}
				break;
			case 2:
				//�鿴�ʹ�
				System.out.println("*****�鿴�ʹ�*****");
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for(int i=0;i<userName.length;i++){
					if(userName[i]!=null){
						String state = States[i]==0 ? "��Ԥ��":"�����";
						System.out.println(i+1+"\t"+userName[i]+"\t"+dishMsg[i]+"\t\t"+times[i]+"��\t"+adress[i]+
								"\t"+sumPrice[i]+"\t"+state);
					}else{
						continue;
					}
				}
				break;		
			case 3:
				//ǩ�ն���
				System.out.println("*****ǩ�ն���*****");
				System.out.println("��Ҫǩ�յĶ�������ǣ�");
				int doneNum = sc.nextInt();
				while(doneNum>userName.length || doneNum<=0){
					System.out.println("��������ȷ����ţ�");
					doneNum = sc.nextInt();
				}
				if(userName[doneNum-1]==null){
					System.out.println("��ѡ��Ķ��������ڣ�");
				}else{
					if(States[doneNum-1]==1){
						System.out.println("����ѡ�Ķ��������ǩ�գ������ٴ�ǩ�գ�");
					}else{
						States[doneNum-1]=1;
						System.out.println("����ǩ�ճɹ���");
					}
				}	
				break;
			case 4:
				//ɾ������
				System.out.println("*****ɾ������*****");
				System.out.println("��ѡ��Ҫɾ���Ķ�����ţ�");
				int deleteID = sc.nextInt();
				boolean isDelete =false;
				int delIndex = -1;
				while(deleteID>userName.length || deleteID<1){
					System.out.println("��������ȷ����ţ�");
					deleteID = sc.nextInt();
				}
				for(int i=0;i<userName.length;i++){
					if(userName[i]!=null && deleteID==i+1){
						if(States[i]==1){
							isDelete = true;
							delIndex = i;
						}else{
							isDelete = true;
							System.out.println("����δ��ɣ��޷�ɾ����");
							break;
						}	
					}
				}
				if(delIndex!=-1){
					for(int i=delIndex+1;i<=userName.length-1;i++){
						userName[i-1]=userName[i];
						dishMsg[i-1] = dishMsg[i];
						times[i-1] = times[i];
						adress[i-1] = adress[i];
						sumPrice[i-1] = sumPrice[i];
						States[i-1] = States[i];
						}
						userName[userName.length-1]=null;
						dishMsg[userName.length-1] =null;
						times[userName.length-1] = 0;
						adress[userName.length-1] = null;
						sumPrice[userName.length-1] = 0.0;
						States[userName.length-1] =0;
						System.out.println("����ɾ���ɹ���");
					}
					if(!isDelete){
						System.out.println("��ѡ��Ķ��������ڣ�");
						break;
					}
				break;
			case 5:
				//��Ҫ����
				System.out.println("*****��Ҫ����*****");
				System.out.println("���\t��Ʒ\t������");
				for(int i=0;i<dishName.length;i++){
					System.out.println(i+1+"\t"+dishName[i]+"\t"+praiseNum[i]+"��");
				}
				System.out.println("��ѡ��Ҫ���޲�Ʒ����ţ�");
				int selectID = sc.nextInt();
				while(selectID-1<0 || selectID>dishName.length){
					System.out.println("��������ȷ����ţ�");
					selectID = sc.nextInt();
				}
				praiseNum[selectID-1] +=1;
				System.out.println("���޳ɹ���");
				break;
			case 6:
				num=0;
				break;
			default:
				break;
			}
			//�����1-5֮������֣��˳�ϵͳ
			if(choose<1 || choose >5){
				break;
			}else{
				System.out.println("����0����");
			}
			
			num = sc.nextInt();
		}while(num==0);
			System.out.println("ллʹ�á�");	
	}
}
