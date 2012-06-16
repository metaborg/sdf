package trans;

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

@SuppressWarnings("all") public class generate_signature_0_0 extends Strategy 
{ 
  public static generate_signature_0_0 instance = new generate_signature_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_signature_0_0");
    Fail106:
    { 
      term = collect_om_1_0.instance.invoke(context, term, lifted36.instance);
      if(term == null)
        break Fail106;
      term = map_1_0.instance.invoke(context, term, templatelang_production_to_signature_0_0.instance);
      if(term == null)
        break Fail106;
      term = termFactory.makeAppl(Main._consSpecification_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSignature_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consConstructors_1, new IStrategoTerm[]{term}), (IStrategoList)trans.constNil0)}), (IStrategoList)trans.constNil0)});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}