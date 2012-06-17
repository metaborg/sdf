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

@SuppressWarnings("all") public class $Fold$Rule_2_0 extends Strategy 
{ 
  public static $Fold$Rule_2_0 instance = new $Fold$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_32790, Strategy z_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FoldRule_2_0");
    Fail1279:
    { 
      IStrategoTerm b_32967 = null;
      IStrategoTerm z_32966 = null;
      IStrategoTerm a_32967 = null;
      IStrategoTerm c_32967 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFoldRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1279;
      z_32966 = term.getSubterm(0);
      a_32967 = term.getSubterm(1);
      IStrategoList annos51 = term.getAnnotations();
      b_32967 = annos51;
      term = y_32790.invoke(context, z_32966);
      if(term == null)
        break Fail1279;
      c_32967 = term;
      term = z_32790.invoke(context, a_32967);
      if(term == null)
        break Fail1279;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFoldRule_2, new IStrategoTerm[]{c_32967, term}), checkListAnnos(termFactory, b_32967));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}