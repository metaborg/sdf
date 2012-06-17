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

@SuppressWarnings("all") public class $References_2_0 extends Strategy 
{ 
  public static $References_2_0 instance = new $References_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_32792, Strategy e_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("References_2_0");
    Fail1304:
    { 
      IStrategoTerm j_32970 = null;
      IStrategoTerm h_32970 = null;
      IStrategoTerm i_32970 = null;
      IStrategoTerm k_32970 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consReferences_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1304;
      h_32970 = term.getSubterm(0);
      i_32970 = term.getSubterm(1);
      IStrategoList annos75 = term.getAnnotations();
      j_32970 = annos75;
      term = d_32792.invoke(context, h_32970);
      if(term == null)
        break Fail1304;
      k_32970 = term;
      term = e_32792.invoke(context, i_32970);
      if(term == null)
        break Fail1304;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consReferences_2, new IStrategoTerm[]{k_32970, term}), checkListAnnos(termFactory, j_32970));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}