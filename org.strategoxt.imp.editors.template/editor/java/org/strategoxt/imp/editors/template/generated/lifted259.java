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

@SuppressWarnings("all") final class lifted259 extends Strategy 
{ 
  public static final lifted259 instance = new lifted259();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail705:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consterm_1 != ((IStrategoAppl)term).getConstructor())
        break Fail705;
      IStrategoTerm arg607 = term.getSubterm(0);
      if(arg607.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg607).getConstructor())
        break Fail705;
      IStrategoTerm arg608 = arg607.getSubterm(0);
      if(arg608.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg608).getConstructor())
        break Fail705;
      IStrategoTerm arg609 = arg608.getSubterm(0);
      if(arg609.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg609).getConstructor())
        break Fail705;
      IStrategoTerm arg610 = arg609.getSubterm(0);
      if(arg610.getTermType() != IStrategoTerm.STRING || !"completion".equals(((IStrategoString)arg610).stringValue()))
        break Fail705;
      IStrategoTerm arg611 = arg608.getSubterm(1);
      if(arg611.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg611).isEmpty())
        break Fail705;
      IStrategoTerm arg612 = ((IStrategoList)arg611).head();
      if(arg612.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg612).getConstructor())
        break Fail705;
      IStrategoTerm arg613 = arg612.getSubterm(0);
      if(arg613.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg613).getConstructor())
        break Fail705;
      IStrategoTerm arg614 = arg613.getSubterm(0);
      if(arg614.getTermType() != IStrategoTerm.STRING || !"avoid".equals(((IStrategoString)arg614).stringValue()))
        break Fail705;
      IStrategoTerm arg615 = ((IStrategoList)arg611).tail();
      if(arg615.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg615).isEmpty())
        break Fail705;
      if(true)
        return term;
    }
    return null;
  }
}