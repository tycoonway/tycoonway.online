function format(res){
	if(res > 10000000000000000000000000000){
		var nres =  (res/1000000000000000000000000000).toFixed(2) + " cc";
		return nres;
	}else if(res > 10000000000000000000000000){
		var nres =  (res/1000000000000000000000000).toFixed(2) + " c";
		return nres;
	}else if(res > 10000000000000000000000){
		var nres =  (res/1000000000000000000000).toFixed(2) + " bb";
		return nres;
	}else if(res > 10000000000000000000){
		var nres =  (res/1000000000000000000).toFixed(2) + " b";
		return nres;
	}else if(res > 10000000000000000){
		var nres =  (res/1000000000000000).toFixed(2) + " aa";
		return nres;
	}else if(res > 10000000000000){
		var nres =  (res/1000000000000).toFixed(2) + " a";
		return nres;
	}else if(res > 10000000000){
		var nres =  (res/1000000000).toFixed(2) + " t";
		return nres;
	}else if(res > 10000000){
		var nres =  (res/1000000).toFixed(2) + " m";
		return nres;
	}else if(res > 10000){
		var nres =  (res/1000).toFixed(2) + " k";
		return nres;
	}else{
		return res;
	}
	
}