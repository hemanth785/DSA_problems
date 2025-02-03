package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
  
  public static void main(String[] args) {
    int[] prices = {2, 8, 11, 14, 15, 19, 21};
    int maxProfit = cutRod(prices, 7);
    System.out.println("maxProfit: "+maxProfit);
    // System.out.println("tableSize: "+size);

  }


  static class SizeValue {
		int size;
    int price;
		double pricePerLen;

		SizeValue(int size, int price, double pricePerLen){
			this.size = size;
      this.price = price;
			this.pricePerLen = pricePerLen;
		}
	}

	public static int cutRod(int price[], int rodLen) {
		List<SizeValue> sizeValList = new ArrayList<>();
		for(int i=0; i<price.length; i++){
			sizeValList.add(new SizeValue(i+1, price[i], (double)price[i]/(i+1)));
		}

		Collections.sort(sizeValList, (a, b) -> {
			if(a.pricePerLen > b.pricePerLen){
				return -1;
			} else {
				return 0;
			}
		});

    int maxProfit = 0;
    for(SizeValue item: sizeValList){
      while(rodLen >= item.size){
        maxProfit += item.price;
        rodLen = rodLen - item.size;
      }

      if(rodLen == 0){
        break;
      } 
    }

		for(SizeValue item: sizeValList){
      System.out.println("size: "+ item.size+ " - "+item.price+ " - "+item.pricePerLen);
    }


		return maxProfit;
	}

}




