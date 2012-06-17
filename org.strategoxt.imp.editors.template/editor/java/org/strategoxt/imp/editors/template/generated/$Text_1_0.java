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

@SuppressWarnings("all") public class $Text_1_0 extends Strategy 
{ 
  public static $Text_1_0 instance = new $Text_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Text_1_0");
    Fail1363:
    { 
      IStrategoTerm c_32979 = null;
      IStrategoTerm b_32979 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consText_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1363;
      b_32979 = term.getSubterm(0);
      IStrategoList annos127 = term.getAnnotations();
      c_32979 = annos127;
      term = n_32795.invoke(context, b_32979);
      if(term == null)
        break Fail1363;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, c_32979));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}