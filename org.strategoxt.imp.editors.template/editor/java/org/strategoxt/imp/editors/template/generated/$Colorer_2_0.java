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

@SuppressWarnings("all") public class $Colorer_2_0 extends Strategy 
{ 
  public static $Colorer_2_0 instance = new $Colorer_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_9753, Strategy x_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Colorer_2_0");
    Fail485:
    { 
      IStrategoTerm f_9932 = null;
      IStrategoTerm d_9932 = null;
      IStrategoTerm e_9932 = null;
      IStrategoTerm g_9932 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorer_2 != ((IStrategoAppl)term).getConstructor())
        break Fail485;
      d_9932 = term.getSubterm(0);
      e_9932 = term.getSubterm(1);
      IStrategoList annos58 = term.getAnnotations();
      f_9932 = annos58;
      term = w_9753.invoke(context, d_9932);
      if(term == null)
        break Fail485;
      g_9932 = term;
      term = x_9753.invoke(context, e_9932);
      if(term == null)
        break Fail485;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorer_2, new IStrategoTerm[]{g_9932, term}), checkListAnnos(termFactory, f_9932));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}