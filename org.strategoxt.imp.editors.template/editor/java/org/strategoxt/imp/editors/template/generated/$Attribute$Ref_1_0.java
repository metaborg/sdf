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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("AttributeRef_1_0");
    Fail1269:
    { 
      IStrategoTerm f_32965 = null;
      IStrategoTerm e_32965 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consAttributeRef_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1269;
      e_32965 = term.getSubterm(0);
      IStrategoList annos42 = term.getAnnotations();
      f_32965 = annos42;
      term = f_32790.invoke(context, e_32965);
      if(term == null)
        break Fail1269;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consAttributeRef_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, f_32965));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}