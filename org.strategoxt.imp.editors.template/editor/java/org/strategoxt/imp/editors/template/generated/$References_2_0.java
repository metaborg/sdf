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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_9753, Strategy v_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("References_2_0");
    Fail484:
    { 
      IStrategoTerm a_9932 = null;
      IStrategoTerm y_9931 = null;
      IStrategoTerm z_9931 = null;
      IStrategoTerm b_9932 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consReferences_2 != ((IStrategoAppl)term).getConstructor())
        break Fail484;
      y_9931 = term.getSubterm(0);
      z_9931 = term.getSubterm(1);
      IStrategoList annos57 = term.getAnnotations();
      a_9932 = annos57;
      term = u_9753.invoke(context, y_9931);
      if(term == null)
        break Fail484;
      b_9932 = term;
      term = v_9753.invoke(context, z_9931);
      if(term == null)
        break Fail484;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consReferences_2, new IStrategoTerm[]{b_9932, term}), checkListAnnos(termFactory, a_9932));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}