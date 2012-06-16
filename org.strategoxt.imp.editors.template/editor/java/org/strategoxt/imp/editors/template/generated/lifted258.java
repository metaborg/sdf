package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") final class lifted258 extends Strategy 
{ 
  public static final lifted258 instance = new lifted258();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail706:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consterm_1 != ((IStrategoAppl)term).getConstructor())
        break Fail706;
      IStrategoTerm arg598 = term.getSubterm(0);
      if(arg598.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg598).getConstructor())
        break Fail706;
      IStrategoTerm arg599 = arg598.getSubterm(0);
      if(arg599.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg599).getConstructor())
        break Fail706;
      IStrategoTerm arg600 = arg599.getSubterm(0);
      if(arg600.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg600).getConstructor())
        break Fail706;
      IStrategoTerm arg601 = arg600.getSubterm(0);
      if(arg601.getTermType() != IStrategoTerm.STRING || !"completion".equals(((IStrategoString)arg601).stringValue()))
        break Fail706;
      IStrategoTerm arg602 = arg599.getSubterm(1);
      if(arg602.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg602).isEmpty())
        break Fail706;
      IStrategoTerm arg603 = ((IStrategoList)arg602).head();
      if(arg603.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg603).getConstructor())
        break Fail706;
      IStrategoTerm arg604 = arg603.getSubterm(0);
      if(arg604.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg604).getConstructor())
        break Fail706;
      IStrategoTerm arg605 = arg604.getSubterm(0);
      if(arg605.getTermType() != IStrategoTerm.STRING || !"prefer".equals(((IStrategoString)arg605).stringValue()))
        break Fail706;
      IStrategoTerm arg606 = ((IStrategoList)arg602).tail();
      if(arg606.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg606).isEmpty())
        break Fail706;
      if(true)
        return term;
    }
    return null;
  }
}