package dicttionary;

import java.util.ArrayList;
/**
 * siftUp and siftDawn was taken as a template form youtube -- https://www.youtube.com/watch?v=W81Qzuz4qH0
 * @author lehom
 *
 */

public class Heap{
	ArrayList<Separator> items = new ArrayList<>();
	LoadList loadList; 
	public Heap() throws Exception {
		loadList = new LoadList();
		items = loadList.addTerms();
	}

	public void insert(Separator word) {
		items.add(word);
		siftUp();
	}

	private void siftUp() {
		int k = items.size() -1;
		while (k > 0 ) {
			int p = (k-1) /2;
			Separator item = items.get(k);
			Separator parent = items.get(p);
			if (item.compareTo(parent)> 0) {
				items.set(k, parent);
				items.set(p, item);

				k = p;
			}
			else {
				break;
			}
		}
	}


	@SuppressWarnings("unused")
	private void siftDown() {
		int k = 0;
		int l = 2*k+1;
		while (l < items.size()) {
			int max = l, r = l + 1;
			if(r< items.size()){
				if (items.get(r).compareTo(items.get(max))<0){
					max++;
					//				}
					//			}
					if (items.get(k).compareTo(items.get(max))<0){
						// switch
						Separator temp = items.get(k);
						items.set(k, items.get(max));
						items.set(max, temp);
						k = max;
						l = 2*k+1;
					}
				}else {
					break;
				}
			}}

	}

	public void addWord(Separator word) {
		items.add(word);
		siftUp();

	}

	//	public Separator delete (Separator word) {
	//		if (items.size()==0){
	//			throw new NoSuchElementException();
	//		}
	//		if (items.size()== 1){
	//			return items.remove(0);
	//		}
	//		Separator hold = items.get(0);
	//		items.set(0, items.remove(items.size()-1));
	//		siftDown();
	//		return hold;
	//
	//	}
	public int size() {
		return items.size();

	}
	public boolean isEmpty() {
		return items.isEmpty();

	}
//	public String toString() {
//		return items.toString();
//
//	}

	public String bestMatch(String prefix) 
	{
		for (Separator s : items) 
		{
			if (s.spanish.toLowerCase().startsWith(prefix.toLowerCase()))
			{
				return s.spanish;  
			}
		}
		return "THE WORD NO EXIST IN THE LIST";
	}

	public String wordToWord(String inputterm) 
	{

		String result = null;
		if (inputterm != null) 
		{

			for (Separator s : items) 
			{

				if (s.spanish.toLowerCase().equals(inputterm.toLowerCase()))
				{
					result =  s.english;
				}
			}
		}
		else
		{
			return null;
		}

		return result;
	}


}
