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

@SuppressWarnings("all") public class $Sdf$Production_3_0 extends Strategy 
{ 
  public static $Sdf$Production_3_0 instance = new $Sdf$Production_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_9756, Strategy q_9756, Strategy r_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SdfProduction_3_0");
    Fail527:
    { 
      IStrategoTerm f_9939 = null;
      IStrategoTerm c_9939 = null;
      IStrategoTerm d_9939 = null;
      IStrategoTerm e_9939 = null;
      IStrategoTerm g_9939 = null;
      IStrategoTerm h_9939 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail527;
      c_9939 = term.getSubterm(0);
      d_9939 = term.getSubterm(1);
      e_9939 = term.getSubterm(2);
      IStrategoList annos97 = term.getAnnotations();
      f_9939 = annos97;
      term = p_9756.invoke(context, c_9939);
      if(term == null)
        break Fail527;
      g_9939 = term;
      term = q_9756.invoke(context, d_9939);
      if(term == null)
        break Fail527;
      h_9939 = term;
      term = r_9756.invoke(context, e_9939);
      if(term == null)
        break Fail527;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSdfProduction_3, new IStrategoTerm[]{g_9939, h_9939, term}), checkListAnnos(termFactory, f_9939));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}