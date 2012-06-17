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

@SuppressWarnings("all") public class $Color$Rule_2_0 extends Strategy 
{ 
  public static $Color$Rule_2_0 instance = new $Color$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_32790, Strategy s_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRule_2_0");
    Fail1274:
    { 
      IStrategoTerm j_32966 = null;
      IStrategoTerm h_32966 = null;
      IStrategoTerm i_32966 = null;
      IStrategoTerm k_32966 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1274;
      h_32966 = term.getSubterm(0);
      i_32966 = term.getSubterm(1);
      IStrategoList annos47 = term.getAnnotations();
      j_32966 = annos47;
      term = r_32790.invoke(context, h_32966);
      if(term == null)
        break Fail1274;
      k_32966 = term;
      term = s_32790.invoke(context, i_32966);
      if(term == null)
        break Fail1274;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRule_2, new IStrategoTerm[]{k_32966, term}), checkListAnnos(termFactory, j_32966));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}