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

@SuppressWarnings("all") public class $Separator_1_0 extends Strategy 
{ 
  public static $Separator_1_0 instance = new $Separator_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Separator_1_0");
    Fail1364:
    { 
      IStrategoTerm f_32979 = null;
      IStrategoTerm e_32979 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSeparator_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1364;
      e_32979 = term.getSubterm(0);
      IStrategoList annos128 = term.getAnnotations();
      f_32979 = annos128;
      term = o_32795.invoke(context, e_32979);
      if(term == null)
        break Fail1364;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, f_32979));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}