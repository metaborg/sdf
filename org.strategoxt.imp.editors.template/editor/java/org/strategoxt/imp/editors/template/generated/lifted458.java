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

@SuppressWarnings("all") final class lifted458 extends Strategy 
{ 
  public static final lifted458 instance = new lifted458();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1525:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consterm_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1525;
      IStrategoTerm arg760 = term.getSubterm(0);
      if(arg760.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg760).getConstructor())
        break Fail1525;
      IStrategoTerm arg761 = arg760.getSubterm(0);
      if(arg761.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg761).getConstructor())
        break Fail1525;
      IStrategoTerm arg762 = arg761.getSubterm(0);
      if(arg762.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg762).getConstructor())
        break Fail1525;
      IStrategoTerm arg763 = arg762.getSubterm(0);
      if(arg763.getTermType() != IStrategoTerm.STRING || !"completion".equals(((IStrategoString)arg763).stringValue()))
        break Fail1525;
      IStrategoTerm arg764 = arg761.getSubterm(1);
      if(arg764.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg764).isEmpty())
        break Fail1525;
      IStrategoTerm arg765 = ((IStrategoList)arg764).head();
      if(arg765.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg765).getConstructor())
        break Fail1525;
      IStrategoTerm arg766 = arg765.getSubterm(0);
      if(arg766.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg766).getConstructor())
        break Fail1525;
      IStrategoTerm arg767 = arg766.getSubterm(0);
      if(arg767.getTermType() != IStrategoTerm.STRING || !"avoid".equals(((IStrategoString)arg767).stringValue()))
        break Fail1525;
      IStrategoTerm arg768 = ((IStrategoList)arg764).tail();
      if(arg768.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg768).isEmpty())
        break Fail1525;
      if(true)
        return term;
    }
    return null;
  }
}