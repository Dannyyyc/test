package Test;
import java.util.*;
/**
 * 吃货联盟控制台点餐系统
 * @author Danny
 *
 */
//测试一下
public class OrderMsg {
	public static void main(String[] args) {
		//主体  一组订单信息
		String[] userName = new String[5];//存储用户姓名
		String[] dishMsg = new String[5];//餐品信息
		int[] times = new int[5];//送餐时间
		String[] adress = new String[5];//送餐地址
		int[] States = new int[5];//订单状态 1：已完成 0：已预订
		double[] sumPrice = new double[5];//总金额
		//初始化
		userName[0] = "张三";
		dishMsg[0] = "烧茄子  2份";
		times[0] = 12;
		adress[0] = "青岛路";
		sumPrice[0] = 36;
		States[0] = 0;

		//数据主体  一组餐品信息
		String[] dishName = {"红烧带鱼","烧茄子","炸鲨鱼","白米饭","小米粥"};
		double[] price ={15.5,26.3,30.5,10,20};
		int[] praiseNum = new int[5];
		 //整体框架
		int num = -1;
		do{
			System.out.println("**********************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐带");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("**********************");
			System.out.print("请选择：");			
			Scanner sc = new Scanner(System.in);
			int choose =sc.nextInt();
			switch(choose){
			case 1:
				//我要点餐
				System.out.println("*****我要订餐*****");
				boolean isAdd = false;
				for(int i=0;i<userName.length;i++){
					//找到要插入的位置
					if(userName[i]==null){
						//记录已找到数据为空的位置
						isAdd = true;
						System.out.println("序号\t菜名\t单价\t点赞数");
						for(int j=1;j<=dishName.length;j++){
							System.out.println(j+".\t"+dishName[j-1]+"\t"+price[j-1]+"\t"+praiseNum[j-1]+"赞");
						}
						System.out.println("请选择您要点的菜品编号：");
						int chooseDish = sc.nextInt();
						System.out.println("请输入您要份数：");
						int number = sc.nextInt();
						System.out.println("请输入订餐人姓名：");
						String name = sc.next();
						System.out.println("请输入送餐时间（10点~20点整点送餐）：");
						int time=sc.nextInt();
						while(time<10||time>20){
								System.out.println("请输入正确的时间！");
								time=sc.nextInt();
							}
						System.out.println("请输入送餐地点：");
						String Adress = sc.next();
						//计算餐费
						double sum= price[chooseDish-1]*number;
						//当餐费大于50元是免6元送餐费
						double songCanFei = sum > 50 ? 0.0 : 6.0;
						System.out.println("订餐成功！");
						System.out.println("您定的是："+dishName[chooseDish-1]+" "+number+"份");
						System.out.println("订餐人："+name);
						System.out.println("送餐时间："+time+"点");
						System.out.println("餐费："+sum+"元"+"  送餐费："+songCanFei+"元");
						System.out.println("总额："+(sum+songCanFei)+"元");
						userName[i]=name;
						dishMsg[i]=dishName[chooseDish-1]+number+"份";
						times[i] = time;
						adress[i] = Adress;
						sumPrice[i] = sum+songCanFei;
						States[i]= 0;
						break;
					}
				}
				//如果没有找到空位置，提示信息
				if(!isAdd){
					System.out.println("不好意思，您的餐带已满。");
				}
				break;
			case 2:
				//查看餐带
				System.out.println("*****查看餐带*****");
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t总金额\t订单状态");
				for(int i=0;i<userName.length;i++){
					if(userName[i]!=null){
						String state = States[i]==0 ? "已预订":"已完成";
						System.out.println(i+1+"\t"+userName[i]+"\t"+dishMsg[i]+"\t\t"+times[i]+"点\t"+adress[i]+
								"\t"+sumPrice[i]+"\t"+state);
					}else{
						continue;
					}
				}
				break;		
			case 3:
				//签收订单
				System.out.println("*****签收订单*****");
				System.out.println("您要签收的订单序号是：");
				int doneNum = sc.nextInt();
				while(doneNum>userName.length || doneNum<=0){
					System.out.println("请输入正确的序号！");
					doneNum = sc.nextInt();
				}
				if(userName[doneNum-1]==null){
					System.out.println("您选择的订单不存在！");
				}else{
					if(States[doneNum-1]==1){
						System.out.println("您所选的订单已完成签收，不能再次签收！");
					}else{
						States[doneNum-1]=1;
						System.out.println("订单签收成功！");
					}
				}	
				break;
			case 4:
				//删除订单
				System.out.println("*****删除订单*****");
				System.out.println("请选择要删除的订单编号：");
				int deleteID = sc.nextInt();
				boolean isDelete =false;
				int delIndex = -1;
				while(deleteID>userName.length || deleteID<1){
					System.out.println("请输入正确的序号！");
					deleteID = sc.nextInt();
				}
				for(int i=0;i<userName.length;i++){
					if(userName[i]!=null && deleteID==i+1){
						if(States[i]==1){
							isDelete = true;
							delIndex = i;
						}else{
							isDelete = true;
							System.out.println("订单未完成，无法删除！");
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
						System.out.println("订单删除成功。");
					}
					if(!isDelete){
						System.out.println("您选择的订单不存在！");
						break;
					}
				break;
			case 5:
				//我要点赞
				System.out.println("*****我要点赞*****");
				System.out.println("序号\t菜品\t点赞数");
				for(int i=0;i<dishName.length;i++){
					System.out.println(i+1+"\t"+dishName[i]+"\t"+praiseNum[i]+"赞");
				}
				System.out.println("请选择要点赞菜品的序号：");
				int selectID = sc.nextInt();
				while(selectID-1<0 || selectID>dishName.length){
					System.out.println("请输入正确的序号！");
					selectID = sc.nextInt();
				}
				praiseNum[selectID-1] +=1;
				System.out.println("点赞成功。");
				break;
			case 6:
				num=0;
				break;
			default:
				break;
			}
			//输入除1-5之间的数字，退出系统
			if(choose<1 || choose >5){
				break;
			}else{
				System.out.println("输入0返回");
			}
			
			num = sc.nextInt();
		}while(num==0);
			System.out.println("谢谢使用。");	
	}
}
