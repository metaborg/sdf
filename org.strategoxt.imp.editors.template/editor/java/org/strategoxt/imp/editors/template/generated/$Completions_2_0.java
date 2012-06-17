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

@SuppressWarnings("all") public class $Completions_2_0 extends Strategy 
{ 
  public static $Completions_2_0 instance = new $Completions_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_32792, Strategy c_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Completions_2_0");
    Fail1303:
    { 
      IStrategoTerm e_32970 = null;
      IStrategoTerm c_32970 = null;
      IStrategoTerm d_32970 = null;
      IStrategoTerm f_32970 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletions_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1303;
      c_32970 = term.getSubterm(0);
      d_32970 = term.getSubterm(1);
      IStrategoList annos74 = term.getAnnotations();
      e_32970 = annos74;
      term = b_32792.invoke(context, c_32970);
      if(term == null)
        break Fail1303;
      f_32970 = term;
      term = c_32792.invoke(context, d_32970);
      if(term == null)
        break Fail1303;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletions_2, new IStrategoTerm[]{f_32970, term}), checkListAnnos(termFactory, e_32970));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}