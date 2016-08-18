package org.metaborg.sdf2table.symbol;

import org.metaborg.sdf2table.core.FixPoint;

public class MetaSymbol extends FixPoint<SymbolClass>{
	SymbolClass _class = null;
	boolean _own_class = false;
	
	@Override
	public void apply(SymbolClass c){
		if(!_own_class){
			if(c == null){ // initialization
				if(dependencies().isEmpty()){
					_own_class = true;
					_class = new SymbolClass();
				}
			}else{
				if(_class == null){
					_class = c;
				}else{
					if(!_own_class && _class != c){
						_own_class = true;
						_class = new SymbolClass();
					}
				}
			}
		}
	}
	
	@Override
	public SymbolClass value(){
		return _class;
	}
}
