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

@SuppressWarnings("all") public class prods_ref_group_1_0 extends Strategy 
{ 
  public static prods_ref_group_1_0 instance = new prods_ref_group_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("prods_ref_group_1_0");
    Fail529:
    { 
      IStrategoTerm p_9939 = null;
      IStrategoTerm o_9939 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consprods_ref_group_1 != ((IStrategoAppl)term).getConstructor())
        break Fail529;
      o_9939 = term.getSubterm(0);
      IStrategoList annos99 = term.getAnnotations();
      p_9939 = annos99;
      term = u_9756.invoke(context, o_9939);
      if(term == null)
        break Fail529;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consprods_ref_group_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, p_9939));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}