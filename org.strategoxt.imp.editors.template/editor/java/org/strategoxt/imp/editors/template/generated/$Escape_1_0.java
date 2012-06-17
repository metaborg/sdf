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

@SuppressWarnings("all") public class $Escape_1_0 extends Strategy 
{ 
  public static $Escape_1_0 instance = new $Escape_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Escape_1_0");
    Fail1337:
    { 
      IStrategoTerm f_32976 = null;
      IStrategoTerm e_32976 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consEscape_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1337;
      e_32976 = term.getSubterm(0);
      IStrategoList annos108 = term.getAnnotations();
      f_32976 = annos108;
      term = l_32794.invoke(context, e_32976);
      if(term == null)
        break Fail1337;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consEscape_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, f_32976));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}