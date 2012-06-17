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

@SuppressWarnings("all") final class lifted457 extends Strategy 
{ 
  public static final lifted457 instance = new lifted457();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1526:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consterm_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1526;
      IStrategoTerm arg751 = term.getSubterm(0);
      if(arg751.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg751).getConstructor())
        break Fail1526;
      IStrategoTerm arg752 = arg751.getSubterm(0);
      if(arg752.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg752).getConstructor())
        break Fail1526;
      IStrategoTerm arg753 = arg752.getSubterm(0);
      if(arg753.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg753).getConstructor())
        break Fail1526;
      IStrategoTerm arg754 = arg753.getSubterm(0);
      if(arg754.getTermType() != IStrategoTerm.STRING || !"completion".equals(((IStrategoString)arg754).stringValue()))
        break Fail1526;
      IStrategoTerm arg755 = arg752.getSubterm(1);
      if(arg755.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg755).isEmpty())
        break Fail1526;
      IStrategoTerm arg756 = ((IStrategoList)arg755).head();
      if(arg756.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg756).getConstructor())
        break Fail1526;
      IStrategoTerm arg757 = arg756.getSubterm(0);
      if(arg757.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg757).getConstructor())
        break Fail1526;
      IStrategoTerm arg758 = arg757.getSubterm(0);
      if(arg758.getTermType() != IStrategoTerm.STRING || !"prefer".equals(((IStrategoString)arg758).stringValue()))
        break Fail1526;
      IStrategoTerm arg759 = ((IStrategoList)arg755).tail();
      if(arg759.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg759).isEmpty())
        break Fail1526;
      if(true)
        return term;
    }
    return null;
  }
}