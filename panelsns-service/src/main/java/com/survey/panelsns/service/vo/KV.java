package com.survey.panelsns.service.vo;

import java.util.Comparator;

public class KV<T,S> {
	
	public static final ValIntegerAscComparator VAL_INTEGER_ASC_COMPARATOR=new ValIntegerAscComparator();
	
	private  T key;
	private  S val;
	
	public KV(T key, S val) {
		super();
		this.key = key;
		this.val = val;
	}
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public S getVal() {
		return val;
	}
	public void setVal(S val) {
		this.val = val;
	}
	
	public static final class ValIntegerAscComparator implements Comparator<KV<String,Integer>>{

		private ValIntegerAscComparator() {
			super();
		}

		@Override
		public int compare(KV<String, Integer> paramT1, KV<String, Integer> paramT2) {
			if(paramT1.val>paramT2.val){
				return 1;
			}else if(paramT1.val<paramT2.val){
				return -1;
			}
			return 0;
		}

		
	}
	
}
