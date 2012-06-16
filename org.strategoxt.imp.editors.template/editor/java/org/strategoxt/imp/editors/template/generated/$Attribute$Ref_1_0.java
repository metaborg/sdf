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

@SuppressWarnings("all") public class $Attribute$Ref_1_0 extends Strategy 
{ 
  public static $Attribute$Ref_1_0 instance = new $Attribute$Ref_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("AttributeRef_1_0");
    Fail449:
    { 
      IStrategoTerm w_9926 = null;
      IStrategoTerm v_9926 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consAttributeRef_1 != ((IStrategoAppl)term).getConstructor())
        break Fail449;
      v_9926 = term.getSubterm(0);
      IStrategoList annos24 = term.getAnnotations();
      w_9926 = annos24;
      term = w_9751.invoke(context, v_9926);
      if(term == null)
        break Fail449;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consAttributeRef_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_9926));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}